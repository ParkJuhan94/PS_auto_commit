SELECT 
    YEAR(DIFFERENTIATION_DATE) AS YEAR,  -- 분화된 연도를 추출
    (MAX(SIZE_OF_COLONY) OVER (PARTITION BY YEAR(DIFFERENTIATION_DATE)) 
     - SIZE_OF_COLONY) AS YEAR_DEV,  -- 연도별 가장 큰 대장균 크기에서 해당 대장균 크기를 뺀 값
    ID  -- 대장균의 ID
FROM 
    ECOLI_DATA
ORDER BY 
    YEAR ASC,  -- 연도 오름차순 정렬
    YEAR_DEV ASC;  -- 편차 오름차순 정렬