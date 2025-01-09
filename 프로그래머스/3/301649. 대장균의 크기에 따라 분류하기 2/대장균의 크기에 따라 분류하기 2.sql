-- 코드를 작성해주세요
select 
    A.ID as ID,
CASE
    WHEN A.PER <= 0.25 then 'CRITICAL'
    WHEN A.PER <= 0.5 then 'HIGH'
    WHEN A.PER <= 0.75 then 'MEDIUM'
    ELSE 'LOW'
END AS COLONY_NAME
from (
    select ID,
    PERCENT_RANK() OVER(order by SIZE_OF_COLONY desc) as PER
    from ECOLI_DATA 
)
as A
order by A.ID asc;