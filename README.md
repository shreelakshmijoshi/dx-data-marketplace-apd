[![Build Status](https://img.shields.io/jenkins/build?jobUrl=https%3A%2F%2Fjenkins.iudx.io%2Fjob%2Fiudx%2520DMP%2520APD%2520(master)%2520pipeline%2F)](https://jenkins.iudx.io/job/iudx%20DMP%20APD%20(master)%20pipeline/lastBuild/)
[![Jenkins Coverage](https://img.shields.io/jenkins/coverage/jacoco?jobUrl=https%3A%2F%2Fjenkins.iudx.io%2Fjob%2Fiudx%2520DMP%2520APD%2520(master)%2520pipeline%2F)](https://jenkins.iudx.io/job/iudx%20DMP%20APD%20(master)%20pipeline/lastBuild/jacoco/)
[![Unit Tests](https://img.shields.io/jenkins/tests?jobUrl=https%3A%2F%2Fjenkins.iudx.io%2Fjob%2Fiudx%2520DMP%2520APD%2520(master)%2520pipeline%2F&label=unit%20tests)](https://jenkins.iudx.io/job/iudx%20DMP%20APD%20(master)%20pipeline/lastBuild/testReport/)
[![Security Tests](https://img.shields.io/jenkins/build?jobUrl=https%3A%2F%2Fjenkins.iudx.io%2Fjob%2Fiudx%2520DMP%2520APD%2520(master)%2520pipeline%2F&label=security%20tests)](https://jenkins.iudx.io/job/iudx%20DMP%20APD%20(master)%20pipeline/lastBuild/zap/)
[![Integration Tests](https://img.shields.io/jenkins/build?jobUrl=https%3A%2F%2Fjenkins.iudx.io%2Fjob%2Fiudx%2520DMP%2520APD%2520(master)%2520pipeline%2F&label=integration%20tests)](https://jenkins.iudx.io/job/iudx%20DMP%20APD%20(master)%20pipeline/lastBuild/Integration_20Test_20Report/)

<p align="center">
<img src="./docs/cdpg.png" width="300">
</p>


# dx-data-marketplace-apd

The data marketplace is Data Exchange's platform that enables data Providers to host their resources bundled as a product.
Likewise, data consumers can buy the products listed by various providers. The consumers can make purchases against a
product variant of the any product. Providers can receive payments through [Razorpay](https://razorpay.com/docs/) which
is implemented as the payment gateway.
All users can interact with the data marketplace API server using HTTPs requests.


<p align="center">
<img src="./docs/dmp-apd-overview.png">
</p>


## Features

- Provider can onboard to Razorpay as merchant using the marketplace's Linked Account Creation flow.
- Provider can create a product by bundling their resources and then create product-variants by adding various
  capabilities / constraints to access those resources.
- Consumers can fetch latest resources, products, product-variants and filter them accordingly.
- Consumers can place orders and make payments against an order via Razorpay.
- Consumers can list all the purchases they have made.
- Providers can also list the purchases made against all their resources or products and filter them accordingly.
- When a payment is successful and verified, resource access policies are created for the given consumer.
- Razorpay interacts with the server using webhooks to feed real-time information related to transactions and payments
- Secure data access over TLS
- The data marketplace is scalable and uses open source components like Vert.x toolkit for asynchronous operation,
  RabbitMQ as a databroker for auditing requests, PostgreSQL as a database
- Integration with DX Catalogue Server for understanding resource metadata, DX Auth Server for token introspection and
  DX Auditing Server for metering


# Explanation
## Understanding DMP APD
- The section available [here](./docs/Solution_Architecture.md) explains the components/services used in implementing the DMP-APD server
- To try out the APIs, import the API collection, postman environment files in postman
- Reference : [postman-collection](https://github.com/datakaveri/iudx-data-marketplace-apd/blob/main/src/test/resources/DX-Data-Marketplace-APIs.postman_collection.json), [postman-environment](https://github.com/datakaveri/iudx-data-marketplace-apd/blob/main/src/test/resources/postman-environment.json)

# How To Guide
## Setup and Installation
Setup and Installation guide is available [here](./docs/Setup-and-Installation.md)

# Tutorial
## Tutorials and Explanation
The following video depicts the steps to publish the product, variant on Data Marketplace

  <video src="https://github.com/user-attachments/assets/7e08b319-adf0-482d-83e8-3b4ec56845eb" controls="controls" style="max-width: 730px;"></video>
  <video src="https://github.com/user-attachments/assets/7e08b319-adf0-482d-83e8-3b4ec56845eb" controls="controls" style="max-width: 730px;">
  </video>
  [![YouTube](http://i.ytimg.com/vi/P0HsnOmAPn8/hqdefault.jpg)](https://www.youtube.com/watch?v=P0HsnOmAPn8)

   <video src="example-tutorials/Linked-account-creation.mp4" placeholder="Product-variant-creation" autoplay loop controls muted title="Variant-creation">
    Sorry, your browser doesn't support HTML 5 video.
   </video>
  
  <video src="https://github.com/user-attachments/assets/47d929cc-0c6b-4b67-9204-2359bda0fae0" controls="controls" style="max-width: 730px;">
  </video>
  <video src="https://github.com/user-attachments/assets/73a4a09e-b439-48a4-aa64-b819884363d3" controls="controls" style="max-width: 730px;">
  </video>
  <video src="https://github.com/user-attachments/assets/f82532b4-0911-4e39-9a86-ee25565e1e28" controls="controls" style="max-width: 730px;">
  </video>
  <video src="https://github.com/user-attachments/assets/3dd62d52-dcb9-417e-bb91-375e3dcf6e64" controls="controls" style="max-width: 730px;">
  </video>
  <video src="https://github.com/user-attachments/assets/3624afe7-bb33-448a-91dc-f654a5f754ec" controls="controls" style="max-width: 730px;">
  </video>

# Reference
## API Docs
API docs are available [here](https://redocly.github.io/redoc/?url=https://raw.githubusercontent.com/datakaveri/iudx-data-marketplace-apd/refs/heads/main/docs/openapi.yaml)

## FAQ
FAQs are available [here](./docs/FAQ.md)


