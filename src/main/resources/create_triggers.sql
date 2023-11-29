use cms;

CREATE TRIGGER after_course_insert
    AFTER INSERT ON courses
    FOR EACH ROW
BEGIN

    INSERT IGNORE INTO tags (name,type) VALUES (NEW.dept, 1), (NEW.name, 2);
END;