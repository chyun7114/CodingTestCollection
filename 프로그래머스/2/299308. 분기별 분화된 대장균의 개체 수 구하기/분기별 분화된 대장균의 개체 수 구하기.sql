-- 코드를 작성해주세요
select  
case 
    when DATE_FORMAT(DIFFERENTIATION_DATE, '%m') IN ('01', '02', '03') then '1Q'
    when DATE_FORMAT(DIFFERENTIATION_DATE, '%m') IN ('04', '05', '06') then '2Q'
    when DATE_FORMAT(DIFFERENTIATION_DATE, '%m') IN ('07', '08', '09') then '3Q'
    when DATE_FORMAT(DIFFERENTIATION_DATE, '%m') IN ('10', '11', '12') then '4Q'
END as QUARTER,
count(*) as ECOLI_COUNT
from ECOLI_DATA
group by QUARTER
ORDER BY QUARTER;