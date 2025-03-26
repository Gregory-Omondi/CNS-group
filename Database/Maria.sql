--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

-- Started on 2025-02-16 18:16:21

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 16576)
-- Name: courses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.courses (
    course_id character varying(4) NOT NULL,
    course_name character varying(15),
    credits integer,
    instructor character varying(30)
);


ALTER TABLE public.courses OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16582)
-- Name: enrollments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enrollments (
    enrollment_id character varying(4) NOT NULL,
    student_id integer,
    course_id character varying(4),
    grade integer
);


ALTER TABLE public.enrollments OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16585)
-- Name: instructor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.instructor (
    instructor_id character varying(4) NOT NULL,
    instructor_name character varying(30),
    email character varying(30)
);


ALTER TABLE public.instructor OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16579)
-- Name: students; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.students (
    student_id integer NOT NULL,
    student_name character varying(30),
    email character varying(30)
);


ALTER TABLE public.students OWNER TO postgres;

--
-- TOC entry 4908 (class 0 OID 16576)
-- Dependencies: 217
-- Data for Name: courses; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.courses (course_id, course_name, credits, instructor) FROM stdin;
B001	Networking	3	Kim Jae
B002	OOP	3	John Kennedy
B003	Database	3	Fred Opondo
B004	Calculus	3	Alice Njue
\.


--
-- TOC entry 4910 (class 0 OID 16582)
-- Dependencies: 219
-- Data for Name: enrollments; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.enrollments (enrollment_id, student_id, course_id, grade) FROM stdin;
E001	192935	B001	80
E002	175825	B001	75
E003	165233	B001	70
E004	155772	B001	73
E005	192935	B002	65
E006	175825	B002	70
E007	165233	B002	85
E008	155772	B002	90
E009	192935	B003	74
E010	175825	B003	73
E011	165233	B003	72
E012	155772	B003	71
E013	192935	B004	80
E014	175825	B004	83
E015	165233	B004	87
E016	155772	B004	76
\.


--
-- TOC entry 4911 (class 0 OID 16585)
-- Dependencies: 220
-- Data for Name: instructor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.instructor (instructor_id, instructor_name, email) FROM stdin;
N001	Kim Jae	k.jae@maria.edu
N002	John Kennedy	j.kennedy@maria.edu
N003	Fred Opondo	f.opondo@maria.edu
N004	Alice Njue	a.njue@maria.edu
\.


--
-- TOC entry 4909 (class 0 OID 16579)
-- Dependencies: 218
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.students (student_id, student_name, email) FROM stdin;
192935	James Owen	j.owen@maria.edu
175825	Kimuge Brown	k.brown@maria.edu
165233	Brian Maweu	b.maweu@maria.edu
155772	Stephanie Julie	s.julie@maria.edu
\.


--
-- TOC entry 4754 (class 2606 OID 16589)
-- Name: courses courses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (course_id);


--
-- TOC entry 4758 (class 2606 OID 16593)
-- Name: enrollments enrollments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrollments
    ADD CONSTRAINT enrollments_pkey PRIMARY KEY (enrollment_id);


--
-- TOC entry 4760 (class 2606 OID 16595)
-- Name: instructor instructor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instructor
    ADD CONSTRAINT instructor_pkey PRIMARY KEY (instructor_id);


--
-- TOC entry 4756 (class 2606 OID 16591)
-- Name: students students_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (student_id);


--
-- TOC entry 4761 (class 2606 OID 16601)
-- Name: enrollments enrollments_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrollments
    ADD CONSTRAINT enrollments_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.courses(course_id);


--
-- TOC entry 4762 (class 2606 OID 16596)
-- Name: enrollments enrollments_student_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrollments
    ADD CONSTRAINT enrollments_student_id_fkey FOREIGN KEY (student_id) REFERENCES public.students(student_id);


-- Completed on 2025-02-16 18:16:22

--
-- PostgreSQL database dump complete
--

