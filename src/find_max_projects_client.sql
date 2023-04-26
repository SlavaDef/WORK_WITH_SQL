SELECT name, COUNT(project_id) AS project_count
FROM worker
JOIN project_worker ON project_worker.worker_id = worker.id
WHERE id IN
(
   SELECT worker_id
   FROM  project_worker
   GROUP BY worker_id
   HAVING  COUNT(project_id) in (
       SELECT COUNT(project_id)
        FROM project_worker
        GROUP BY worker_id
        ORDER BY COUNT(project_id) DESC
         LIMIT 1
    )
);