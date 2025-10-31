-- 코드를 작성해주세요
WITH RESULT AS (
    (SELECT a.EMP_NO, 
       a.EMP_NAME, 
       (CASE 
            WHEN b.SCORE >= 96 THEN 'S'
            WHEN b.SCORE >= 90 THEN 'A'
            WHEN b.SCORE >= 80 THEN 'B'
            ELSE 'C'
        END) AS GRADE,
        a.SAL
    FROM HR_EMPLOYEES AS a
    JOIN (SELECT EMP_NO, AVG(SCORE) AS SCORE
          FROM HR_GRADE
          GROUP BY EMP_NO
         ) AS b ON a.EMP_NO = b.EMP_NO
     )
)

SELECT EMP_NO, 
       EMP_NAME, 
       GRADE,
       (CASE
            WHEN GRADE='S' THEN SAL*0.2
            WHEN GRADE='A' THEN SAL*0.15
            WHEN GRADE='B' THEN SAL*0.10
            WHEN GRADE='C' THEN 0       
        END) AS BONUS
FROM RESULT
ORDER BY EMP_NO