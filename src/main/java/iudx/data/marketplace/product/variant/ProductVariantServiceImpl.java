package iudx.data.marketplace.product.variant;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import iudx.data.marketplace.apiserver.exceptions.DxRuntimeException;
import iudx.data.marketplace.common.RespBuilder;
import iudx.data.marketplace.common.ResponseUrn;
import iudx.data.marketplace.postgres.PostgresService;
import iudx.data.marketplace.product.util.QueryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicReference;

import static iudx.data.marketplace.product.util.Constants.*;

public class ProductVariantServiceImpl implements ProductVariantService {

  public static final Logger LOGGER = LogManager.getLogger(ProductVariantServiceImpl.class);
  private final PostgresService pgService;
  private QueryBuilder queryBuilder;

  public ProductVariantServiceImpl(JsonObject config, PostgresService postgresService) {
    this.pgService = postgresService;
    this.queryBuilder = new QueryBuilder(config.getJsonArray(TABLES));
  }

  @Override
  public ProductVariantService createProductVariant(
      JsonObject request, Handler<AsyncResult<JsonObject>> handler) {
    String productID = request.getString(PRODUCT_ID);
    Future<JsonObject> productDetailsFuture = getProductDetails(productID);
    JsonArray datasets = request.getJsonArray(DATASETS);
    productDetailsFuture.onComplete(
        pdfHandler -> {
          if (pdfHandler.succeeded()) {
            JsonObject res = pdfHandler.result().getJsonArray(RESULTS).getJsonObject(0);
            JsonArray resDatasets = res.getJsonArray(DATASETS);
            if (datasets.size() != resDatasets.size()) {
              handler.handle(
                  Future.failedFuture(
                      "Number of datasets is incorrect, required : " + resDatasets.size()));
            }
            int i, j;
            for (i = 0; i < datasets.size(); i++) {
              for (j = 0; j < resDatasets.size(); j++) {
                String reqID = datasets.getJsonObject(i).getString("id");
                String resID = resDatasets.getJsonObject(j).getString("id");
                if (reqID.equalsIgnoreCase(resID)) {
                  resDatasets.getJsonObject(j).mergeIn(datasets.getJsonObject(i));
                }
              }
            }
            request.mergeIn(res);
            String query = queryBuilder.buildCreateProductVariantQuery(request);
            pgService.executeQuery(
                query,
                pgHandler -> {
                  if (pgHandler.succeeded()) {
                    RespBuilder respBuilder =
                        new RespBuilder()
                            .withType(ResponseUrn.SUCCESS_URN.getUrn())
                            .withTitle(ResponseUrn.SUCCESS_URN.getMessage())
                            .withResult(
                                new JsonArray()
                                    .add(new JsonObject().put("id", request.getString("id")).put("variant", request.getString("variant"))));
                    handler.handle(Future.succeededFuture(respBuilder.getJsonResponse()));
                  } else {
                    handler.handle(Future.failedFuture(pgHandler.cause()));
                  }
                });
          } else {
            throw new DxRuntimeException(
                500, ResponseUrn.DB_ERROR_URN, ResponseUrn.DB_ERROR_URN.getMessage());
          }
        });
    return this;
  }

  private Future<JsonObject> getProductDetails(String productID) {
    Promise<JsonObject> promise = Promise.promise();

    String query = queryBuilder.buildProductDetailsQuery(productID);
    pgService.executeQuery(
        query,
        pgHandler -> {
          if (pgHandler.succeeded()) {
            promise.complete(pgHandler.result());
          } else {
            promise.fail(pgHandler.cause());
          }
        });
    return promise.future();
  }

  @Override
  public ProductVariantService updateProductVariant(
      JsonObject request, Handler<AsyncResult<JsonObject>> handler) {
    return null;
  }

  @Override
  public ProductVariantService deleteProductVariant(
      JsonObject request, Handler<AsyncResult<JsonObject>> handler) {
    return null;
  }
}
