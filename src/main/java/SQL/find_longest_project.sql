SELECT CONCAT('Project ', id) as name, DATEDIFF('MONTH', start_date,finish_date) as month_count
FROM project
GROUP BY id
HAVING  month_count =  (
SELECT MAX(DATEDIFF('MONTH', start_date,finish_date))
FROM project
);