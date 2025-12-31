INSERT INTO app_users (
id,
    email,
    first_name,
    last_name,
    password_hash,
    pto_balance,
    yearly_assigned_pto_balance,
    occurrence_balance
) VALUES (
1,
    'tylercsmoot8@gmail.com',
    'Test',
    'User',
    'password',
    200,
    200,
    8
);




INSERT INTO time_request (
    id,
    created_at,
    created_by,
    occurrence_count,
    requested_date,
    requested_hours,
    time_request_status,
    time_type
) VALUES
(1, CURRENT_TIMESTAMP, 'test@company.com', 0, '2025-01-10', 8, 'PENDING', 'UNTIME'),
(2, CURRENT_TIMESTAMP, 'test@company.com', 1, '2025-01-05', 0, 'APPROVED', 'SCHTIME'),
(3, CURRENT_TIMESTAMP, 'test@company.com', 0, '2025-01-20', 4, 'PENDING', 'UNTIME');