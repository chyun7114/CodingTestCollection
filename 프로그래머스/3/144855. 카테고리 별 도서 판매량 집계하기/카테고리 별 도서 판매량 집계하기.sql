-- 코드를 입력하세요
SELECT b.CATEGORY as CATEGORY, SUM(sales) as TOTAL_SALES
from BOOK b inner join BOOK_SALES bs
on b.BOOK_ID = bs.BOOK_ID
where bs.SALES_DATE LIKE '2022-01-%'
group by category
order by category asc;