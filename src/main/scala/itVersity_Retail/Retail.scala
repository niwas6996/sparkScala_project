package itVersity_Retail

import org.joda.time.DateTime

class Departments(
                   var departmentId: Int,
                   var departmentName: String
                 )

class Categories(
                  var categoryId: Int,
                  var categoryDepartmentId: Int,
                  var categoryName: String
                )

class Products(
                var productId: Int,
                var productCategoryId: Int,
                var productName: String,
                var productDescription: String,
                var productPrice: Float,
                var productImage: String
              )

class OrderItem
(
  var orderItemId: Int,
  var orderItemOrderId: Int,
  var orderItemProductId: Int,
  var orderItemQuantity: Int,
  var orderItemSubTotal: Float,
  var orderItemProductPrice: Float
) {
  require(orderItemSubTotal == orderItemQuantity * orderItemProductPrice, "invalid Order Item SubTotal")

  def this(
            orderItemId: Int,
            orderItemOrderId: Int,
            orderItemProductId: Int,
            orderItemQuantity: Int,
            orderItemProductPrice: Float
          ) = {
    this(orderItemId, orderItemOrderId, orderItemProductId, orderItemQuantity,
      orderItemQuantity * orderItemProductPrice, orderItemProductPrice)

  }

  override def toString: String = "OrderItem(" + orderItemId + ","

  orderItemOrderId + ","
  orderItemProductId + ","
  orderItemQuantity + ","
  orderItemSubTotal + ","
  orderItemProductPrice + ")"
}

class Orders(
              var orderId: Int,
              var orderDate: DateTime,
              var orderCustomerId: Int,
              var orderStatus: String
            )

class Customers(
                 var customerId: Int,
                 var customerFname: String,
                 var customerLname: String,
                 var customerEmail: String,
                 var customerPassword: String,
                 var customerStreet: String,
                 var customerCity: String,
                 var customerState: String,
                 var customerZipcode: String
               )

