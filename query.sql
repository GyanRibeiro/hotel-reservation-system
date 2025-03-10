-- 1. Quantos clientes temos na base?
SELECT COUNT(*) AS total_clientes FROM "ProjectHotel".customers;

-- 2. Quantos quartos temos cadastrados?
SELECT COUNT(*) AS total_quartos FROM "ProjectHotel".rooms;

-- 3. Quantas reservas em aberto o hotel possui no momento?
SELECT COUNT(*) AS reservas_em_aberto
FROM "ProjectHotel".reservation
WHERE status = 'SCHEDULED';

-- 4. Quantos quartos temos vagos no momento?
SELECT COUNT(*) AS quartos_vagos
FROM "ProjectHotel".rooms
WHERE id NOT IN (
    SELECT room_id
    FROM "ProjectHotel".reservation
    WHERE status = 'IN_USE'
);

-- 5. Quantos quartos temos ocupados no momento?
SELECT COUNT(*) AS quartos_ocupados
FROM "ProjectHotel".reservation
WHERE status = 'IN_USE';

-- 6. Quantas reservas futuras o hotel possui?
SELECT COUNT(*) AS reservas_futuras
FROM "ProjectHotel".reservation
WHERE check_in_date > CURRENT_DATE;

-- 7. Qual o quarto mais caro do hotel?
SELECT *
FROM "ProjectHotel".rooms
ORDER BY price DESC
    LIMIT 1;

-- 8. Qual o quarto com maior histórico de cancelamentos?
SELECT room_id, COUNT(*) AS total_cancelamentos
FROM "ProjectHotel".reservation
WHERE status = 'CANCELED'
GROUP BY room_id
ORDER BY total_cancelamentos DESC
    LIMIT 1;

-- 9. Liste todos os quartos e a quantidade de clientes que já ocuparam cada um.
SELECT r.id AS quarto_id, r.room_number AS numero_quarto, COUNT(DISTINCT res.customer_id) AS total_clientes
FROM "ProjectHotel".rooms r
         LEFT JOIN "ProjectHotel".reservation res ON r.id = res.room_id
GROUP BY r.id, r.room_number;

-- 10. Quais são os 3 quartos que possuem um histórico maior de ocupações?
SELECT room_id, COUNT(*) AS total_ocupacoes
FROM "ProjectHotel".reservation
WHERE status IN ('IN_USE', 'FINISHED')
GROUP BY room_id
ORDER BY total_ocupacoes DESC
    LIMIT 3;

-- 11. No próximo mês, o hotel fará uma promoção para os seus 10 clientes que possuírem maior histórico de reservas.
SELECT customer_id, COUNT(*) AS total_reservas
FROM "ProjectHotel".reservation
GROUP BY customer_id
ORDER BY total_reservas DESC
    LIMIT 10;