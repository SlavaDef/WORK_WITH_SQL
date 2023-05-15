SELECT
    CONCAT('Project ', project.id) AS Name,
    SUM(salary * DATEDIFF(MONTH, start_date, finish_date)) AS Price
FROM project_worker
JOIN worker on worker.id = project_worker.worker_id
JOIN project on project.id = project_worker.project_id
GROUP BY project_id
ORDER BY SUM(salary * DATEDIFF(MONTH, start_date, finish_date)) DESC;