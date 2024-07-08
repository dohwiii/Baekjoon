# 2022-08~10월 총 대여 횟수 5회 이상
with RentalCounts as (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    group by CAR_ID
    having count(*) >= 5
)   
select MONTH(START_DATE) 'MONTH', r.CAR_ID, COUNT(*) 'RECORDS'
from RentalCounts r join CAR_RENTAL_COMPANY_RENTAL_HISTORY c
using (CAR_ID)
where START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
group by MONTH(START_DATE), c.CAR_ID
order by MONTH(START_DATE) asc, c.CAR_ID desc;

# select CAR_ID, MONTH(START_DATE) 'MONTH' from CAR_RENTAL_COMPANY_RENTAL_HISTORY;
