SELECT USER_ID, NICKNAME, concat(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) as '전체주소', concat(substring(TLNO, 1, 3), '-', substring(TLNO, 4, 4), '-', substring(TLNO, 8, 4)) as '전화번호'
from USED_GOODS_BOARD b join USED_GOODS_USER u on b.writer_id = u.user_id
group by user_id
having count(*) >= 3
order by user_id desc;
