INSERT INTO banking_core_user (id, email, first_name, identification_number, last_name)
VALUES ('617220ff-1642-4490-b589-869e7978c5e0', 'sam@gmail.com', 'Sam', '808829932V', 'Silva');
INSERT INTO banking_core_service.banking_core_user (id, email, first_name, identification_number, last_name)
VALUES ('c2974865-ea1b-4c1c-b471-9c5e92b6eedd', 'guru@gmail.com', 'Guru', '901830556V', 'Darmaraj');
INSERT INTO banking_core_service.banking_core_user (id, email, first_name, identification_number, last_name)
VALUES ('ffb0f37f-1cc7-4d0d-949c-1c3538412d7d','ragu@gmail.com', 'Ragu', '348829932V', 'Sivaraj');
INSERT INTO banking_core_service.banking_core_user (id, email, first_name, identification_number, last_name)
VALUES ('12908c8a-6909-4566-abd8-4c81e6ad3da2','randor@gmail.com', 'Randor', '842829932V', 'Manoon');

INSERT INTO banking_core_account
(id, actual_balance, available_balance, `number`, status, `type`, user_id)
VALUES ('240fe2e2-9a7e-49a5-9788-8c0568dda91a', 100000.00, 100000.00, 100015003000, 'ACTIVE', 'SAVINGS_ACCOUNT', '617220ff-1642-4490-b589-869e7978c5e0'),
       ('dabbfe14-0862-479a-b58e-34db0398fded', 100000.00, 100000.00, 100015003001, 'ACTIVE', 'SAVINGS_ACCOUNT', '617220ff-1642-4490-b589-869e7978c5e0'),
       ('c84a8359-709d-468c-9407-ceec7ef6b329', 100000.00, 100000.00, 100015003002, 'ACTIVE', 'SAVINGS_ACCOUNT', 'c2974865-ea1b-4c1c-b471-9c5e92b6eedd'),
       ('55b97790-5922-4822-9c26-0b3e44088616', 12000.00, 12000.00, 100015003003, 'ACTIVE', 'SAVINGS_ACCOUNT', 'c2974865-ea1b-4c1c-b471-9c5e92b6eedd'),
       ('838f7874-ac62-4801-8014-2813e9545976', 12000.00, 12000.00, 100015003004, 'ACTIVE', 'SAVINGS_ACCOUNT', 'c2974865-ea1b-4c1c-b471-9c5e92b6eedd'),
       ('d08f8c47-edec-4c4e-833d-833f56217f74', 12000.00, 12000.00, 100015003005, 'ACTIVE', 'SAVINGS_ACCOUNT', 'ffb0f37f-1cc7-4d0d-949c-1c3538412d7d'),
       ('39e7082a-ebd9-446d-b609-f9d40cb35066', 290000.00, 290000.00, 100015003006, 'ACTIVE', 'SAVINGS_ACCOUNT', 'ffb0f37f-1cc7-4d0d-949c-1c3538412d7d'),
       ('955327b6-72c9-49e4-9c7c-6009e571bac5', 290000.00, 290000.00, 100015003007, 'ACTIVE', 'SAVINGS_ACCOUNT', 'ffb0f37f-1cc7-4d0d-949c-1c3538412d7d'),
       ('03bb4975-0dd6-4c14-ae07-f7c8e5ccaf68', 290000.00, 290000.00, 100015003008, 'ACTIVE', 'SAVINGS_ACCOUNT', 'ffb0f37f-1cc7-4d0d-949c-1c3538412d7d');


INSERT INTO banking_core_utility_account (id, `number`, provider_name)
VALUES ('e4f65659-9b9b-4d61-9942-090629461fdd', '8203232565', 'VODAFONE');
INSERT INTO banking_core_utility_account (id, `number`, provider_name)
VALUES ('8936dcda-d6d2-4451-933a-d6fcb9940996', '5464546545', 'VERIZON');
INSERT INTO banking_core_utility_account (id, `number`, provider_name)
VALUES ('3f9d0432-6a56-4c01-8de2-69ecfc439409', '6546456464', 'SINGTEL');
INSERT INTO banking_core_utility_account (id, `number`, provider_name)
VALUES ('b8e349ca-0796-4e21-b5fa-14540018fe3b', '7889987999', 'HUTCH');
INSERT INTO banking_core_utility_account (id, `number`, provider_name)
VALUES ('2a3360b8-2dfc-45a6-982b-ddab9d0f20f5', '2132123132', 'AIRTEL');
INSERT INTO banking_core_utility_account (id, `number`, provider_name)
VALUES ('eef5fb25-76a4-45dc-a745-5b5444c8ae41', '61645564646', 'GIO');