-- 코드를 입력하세요
SELECT 
a.AUTHOR_ID, 
a.AUTHOR_NAME,
b.CATEGORY,
SUM((s.SALES * b.PRICE)) AS TOTAL_SALES
FROM BOOK_SALES s
JOIN BOOK b ON s.BOOK_ID = b.BOOK_ID
JOIN AUTHOR A ON a.AUTHOR_ID = b.AUTHOR_ID
WHERE YEAR(s.SALES_DATE) = 2022 AND MONTH(s.SALES_DATE) = 1
GROUP BY b.CATEGORY, a.AUTHOR_ID
ORDER BY a.AUTHOR_ID ASC, b.CATEGORY DESC;