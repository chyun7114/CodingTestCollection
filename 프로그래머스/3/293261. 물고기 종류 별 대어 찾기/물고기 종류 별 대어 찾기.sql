-- 코드를 작성해주세요
SELECT f.ID, n.FISH_NAME, f.LENGTH AS LENGTH
FROM FISH_INFO f INNER JOIN FISH_NAME_INFO n
ON f.FISH_TYPE = n.FISH_TYPE
WHERE f.FISH_TYPE IN (
    SELECT FISH_TYPE
    FROM FISH_INFO
    GROUP BY FISH_TYPE
    HAVING LENGTH = MAX(LENGTH)
)
ORDER BY f.ID ASC;