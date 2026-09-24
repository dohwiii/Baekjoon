-- 코드를 입력하세요
-- 2022년 5월 진료과코드 별로 조회
-- 진료과별 예약한 환자 수 오름차순, 진료과 코드 오름차순
-- 5월 컷하고 진료과별 집계

SELECT MCDP_CD, count(*) as "5월예약건수"
from APPOINTMENT
where TO_CHAR(APNT_YMD, 'YYYY-MM') = '2022-05'
group by MCDP_CD
order by "5월예약건수", MCDP_CD;
