-- 코드를 입력하세요
SELECT APNT_NO, PT_NAME, a.PT_NO, a.MCDP_CD, DR_NAME, APNT_YMD
from APPOINTMENT a
    join PATIENT p using (PT_NO)
    join DOCTOR d on d.DR_ID = a.MDDR_ID
where DATE_FORMAT(APNT_YMD, '%Y-%m-%d') = '2022-04-13' and APNT_CNCL_YN = 'N' and a.MCDP_CD = 'CS'
order by APNT_YMD;