--Exercise 6
select * from Production.ProductListPriceHistory
create trigger listPrice
on Production.ProductListPriceHistory
for insert 
as
declare @percent varchar(4)
set @percent=(select case 
				when Ins.ListPrice*0.15<ph.ListPrice then 'Y' else 'N' end
				from Production.ProductListPriceHistory ph inner join inserted Ins
				on ph.ProductID = Ins.ProductID
			  )
