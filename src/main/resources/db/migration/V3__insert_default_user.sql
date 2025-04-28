INSERT INTO users (username, password, enabled)
VALUES ('user', '$2a$10$ux.lDonjH2qt2zYy0lNsn.702zx9BPjm.m2.LNewVGHNZQmA2Iega', true);

INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER');
