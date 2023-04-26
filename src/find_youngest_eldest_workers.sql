SELECT  'YOUNGEST' AS TYPE, name, birthday
FROM worker
GROUP BY name
HAVING DATEDIFF(DAY, birthday , current_date) = (
SELECT  MIN(DATEDIFF(DAY, birthday , current_date))
FROM worker)

UNION ALL

SELECT  'ELDEST' AS TYPE, name, birthday
FROM worker
GROUP BY name
HAVING DATEDIFF(DAY, birthday , current_date) = (
SELECT  MAX(DATEDIFF(DAY, birthday , current_date))
FROM worker
);