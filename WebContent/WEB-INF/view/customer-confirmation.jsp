<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Confirmation</title>
</head>
<body>

The customer is confirmed: ${customer.firstName} ${customer.lastName}
<br><br>

Free passes: ${customer.freePasses}
<br><br>

Postal Code: ${customer.postalCode}
</body>
</html>