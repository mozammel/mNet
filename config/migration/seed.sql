-- seed data to login
-- username: admin
-- password: adMin#12345


INSERT INTO `user` (`id`, `created_date`, `last_modified_date`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `designation`, `email`, `enabled`, `full_name`, `hashed_password`, `phone_number`, `salt`, `username`, `version`, `created_by`, `last_modified_by`) VALUES
(1, '2015-04-19 01:08:23', '2015-04-19 01:08:23', b'1', b'1', b'1', 'OPERATOR', 'admin@mnetservices.com', b'1', 'Demo User', '88dae32abb58a77c245637518689fae398a5b7cc62265cf7ec8e05505be64eb8', '01671000000', 'bYrjKdsstG4w68nw', 'admin', 0, 1, 1);


INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(1, 'ROLE_ADMIN');