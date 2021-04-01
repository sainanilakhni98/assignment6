-------------------------Exercise 3----------------
select top(5) SalesOrderID,AccountNumber,TotalDue from Sales.SalesOrderHeader so
where so.TotalDue>70000 order by OrderDate desc,TotalDue desc;