INSERT INTO app_users (

    email,
    first_name,
    last_name,
    password_hash,
    remaining_pto_balance,
    yearly_assigned_pto_balance,
    occurrence_balance
) VALUES (

    'tylercsmoot8@gmail.com',
    'Test',
    'User',
    'password',
    182,
    200,
    7
);




INSERT INTO time_request (
    created_at,
    created_by,
    occurrence_count,
    requested_date,
    requested_hours,
    time_request_status,
    time_type
) VALUES
(CURRENT_TIMESTAMP, 'test@company.com', 1, '2025-01-10', 8, 'AUTO_APPROVED', 'UNTIME'),
(CURRENT_TIMESTAMP, 'test@company.com', 0, '2025-01-05', 10, 'APPROVED', 'SCHTIME'),
(CURRENT_TIMESTAMP, 'test@company.com', 0, '2025-01-20', 10, 'PENDING', 'SCHTIME');