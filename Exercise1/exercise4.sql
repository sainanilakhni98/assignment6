use AdventureWorks2016;

--Exercise 4
create function sale_order_detail(
@salesOrderId int,
@CurrencyCode varchar(10),
@Date varchar(60)
)
returns table as 
return 
select so.SalesOrderID,sc.ToCurrencyCode as [Currency Code],so.ModifiedDate,
so.OrderQty as OrderQuantity,so.ProductID,so.UnitPrice*sc.EndOfDayRate as UnitPrice
from Sales.SalesOrderDetail so,sales.CurrencyRate sc 
where so.SalesOrderID=@salesOrderId and sc.ToCurrencyCode=@CurrencyCode
and so.ModifiedDate=@Date; 

select * from sale_order_detail(43659,'CAD','2011-05-31 00:00:00.000');



