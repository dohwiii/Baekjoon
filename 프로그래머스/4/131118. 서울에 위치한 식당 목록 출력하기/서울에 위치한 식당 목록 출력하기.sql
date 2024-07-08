# 서울
select i.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, ROUND(AVG(REVIEW_SCORE), 2) 'SCORE'
from REST_INFO i join REST_REVIEW r
using (REST_ID)
where substring(ADDRESS, 1, 2) = '서울'
group by r.REST_ID
order by SCORE desc, FAVORITES desc;