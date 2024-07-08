select HISTORY_ID, CAR_ID, date_format(START_DATE, '%Y-%m-%d') 'START_DATE', date_format(END_DATE, '%Y-%m-%d') 'END_DATE', 
    (case
        when DATEDIFF(END_DATE, START_DATE) >= 29 then '장기 대여'
        else '단기 대여'
     end) as 'RENT_TYPE'
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where YEAR(START_DATE) = 2022 and MONTH(START_DATE) = 9
order by HISTORY_ID desc;

# select * from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where DATEDIFF(END_DATE, START_DATE) >= 30