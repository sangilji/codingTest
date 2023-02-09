-- 코드를 입력하세요
SELECT p.member_name, r.review_text, date_format(r.review_date,"%Y-%m-%d") from member_profile p 
join rest_review r
on p.member_id = r.member_id
where r.member_id in (select member_id from rest_review group by member_id having count(*) >= (select count(*) from rest_review group by member_id order by 1 desc limit 1))
order by 3, 2; 
