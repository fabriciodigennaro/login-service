CREATE TABLE tokens (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    token VARCHAR(512) UNIQUE NOT NULL,
    token_type VARCHAR(50),
    revoked BOOLEAN NOT NULL DEFAULT FALSE,
    expired BOOLEAN NOT NULL DEFAULT FALSE,
    user_id UUID,
    FOREIGN KEY (user_id) REFERENCES users(id)
);