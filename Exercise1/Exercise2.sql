---------------------------------Excercise 2------------------

-----query using join
select sc.CustomerID,sc.AccountNumber from Sales.Customer as sc
Left Join Sales.SalesOrderHeader so on sc.CustomerID=so.CustomerID
where so.OrderDate is null;

------query using subquery and Not Exists
select sc.CustomerID,sc.AccountNumber from Sales.Customer as sc
where Not Exists(select OrderDate from Sales.SalesOrderHeader so
where sc.CustomerID=so.CustomerID);