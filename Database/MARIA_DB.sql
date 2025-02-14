--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

-- Started on 2025-02-14 13:34:19

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
-- TOC entry 217 (class 1259 OID 24612)
-- Name: courses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.courses (
    course_id character varying(4),
    course_name character varying(15),
    credits integer,
    instructor character varying(30)
);


ALTER TABLE public.courses OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 24618)
-- Name: enrollments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enrollments (
    enrollment_id character varying(4),
    student_id integer,
    course_id character varying(4),
    grade integer
);


ALTER TABLE public.enrollments OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 24615)
-- Name: students; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.students (
    student_id integer,
    student_name character varying(30),
    email character varying(30)
);


ALTER TABLE public.students OWNER TO postgres;

--
-- TOC entry 4847 (class 0 OID 24612)
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
-- TOC entry 4849 (class 0 OID 24618)
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
-- TOC entry 4848 (class 0 OID 24615)
-- Dependencies: 218
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.students (student_id, student_name, email) FROM stdin;
192935	James Owen	j.owen@maria.edu
175825	Kimuge Brown	k.brown@maria.edu
165233	Brian Maweu	b.maweu@maria.edu
155772	Stephanie Julie	s.julie@maria.edu
\.


-- Completed on 2025-02-14 13:34:19

--
-- PostgreSQL database dump complete
--

