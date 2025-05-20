select count(*) as FISH_COUNT, FISH_NAME
from FISH_INFO f join FISH_NAME_INFO fn
on f.FISH_TYPE = fn.FISH_TYPE
group by FISH_NAME
order by FISH_COUNT desc;