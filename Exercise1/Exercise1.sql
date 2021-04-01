-----------------------Exercise 1--------------------------------

-----Q1
use AdventureWorks2016
select * from Sales.SalesPerson;

-----Q2
select FirstName, LastName from Person.Person Where FirstName like 'B%';

-----Q3
select FirstName, LastName,JobTitle from HumanResources.Employee hre inner join Person.Person pp
on hre.BusinessEntityID=pp.BusinessEntityID 
where JobTitle in ('Design Engineer','Tool Designer','Marketing Assistant');

-----Q4
select Name,color,weight as Maximum_weight from Production.Product
where weight in (select max(weight) from Production.Product);

----Q5
Select Description,isnull(MaxQty,0) as MaxQty from sales.SpecialOffer

-----Q6
select Avg(AverageRate) as 'Average exchange rate' from Sales.CurrencyRate
where FromCurrencyCode='USD' and ToCurrencyCode='GBP' and
ModifiedDate like '%2011%';

-----Q7
select FirstName,LastName,ROW_NUMBER() over(order By (select null)) 
as Sequential_Number from Person.Person where FirstName like '%ss%'; 

----Q8
alter table Sales.SalesPerson add CommissionBand varchar(6);
update Sales.SalesPerson set CommissionBand = 
case 
when CommissionPct=0.00 then 'Band 0'
when CommissionPct>0.00 and CommissionPct<=0.01 then 'Band 1'
when CommissionPct>0.01 and CommissionPct<=0.015 then 'Band 2'
when CommissionPct>0.015 then 'Band 3'
end;
select BusinessEntityID as SalesPersonId, CommissionBand from Sales.SalesPerson;


-----Q9
select  pp.PersonType, pp.FirstName + ' ' + pp.LastName as Name,hre.JobTitle 
from HumanResources.Employee hre inner join Person.Person pp
on hre.BusinessEntityID=pp.BusinessEntityID where pp.PersonType='EM';

-----Q10
select ProductID,SafetyStockLevel as LargestStock from Production.Product 
where SafetyStockLevel = (select max(SafetyStockLevel) from Production.Product);


