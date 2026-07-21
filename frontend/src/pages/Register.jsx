import { useState } from "react";
import { Link } from "react-router-dom";
import {
    FaUser,
    FaEnvelope,
    FaPhone,
    FaLock,
    FaUserTag
} from "react-icons/fa";

import "./Register.css";

export default function Register() {

    const [role, setRole] = useState("student");
    const [userId, setUserId] = useState("");
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [mobile, setMobile] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [agree, setAgree] = useState(false);

    const getIdPlaceholder = () => {

        switch (role) {

            case "college":
                return "College ID";

            case "department":
                return "Department ID";

            case "faculty":
                return "Faculty ID";

            case "student":
                return "Student ID";

            case "client":
                return "Client ID";

            default:
                return "User ID";
        }

    };

    const handleRegister = () => {

        if (
            !userId ||
            !name ||
            !email ||
            !mobile ||
            !password ||
            !confirmPassword
        ) {

            alert("Please fill all fields.");
            return;

        }

        if (
            role === "student" ||
            role === "faculty"
        ) {

            if (!email.endsWith("@mits.ac.in")) {

                alert("Use your official @mits.ac.in email.");

                return;

            }

        }

        if (password !== confirmPassword) {

            alert("Passwords do not match.");

            return;

        }

        if (!agree) {

            alert("Please accept the Terms & Conditions.");

            return;

        }

        alert("Registration logic will be implemented in Spring Boot.");

    };

    return (

        <div className="register-page">

            <div className="register-left">

                <img
                    src="/register-illustration.png"
                    alt="Register"
                />

                <h1>Join Project Management System</h1>

                <p>

                    Register to manage projects,
                    students, faculty and departments.

                </p>

            </div>

            <div className="register-right">

                <div className="register-card">

                    <h2>Create Account</h2>

                    <p>Create your account to continue</p>

                    <div className="input-group">

                        <FaUserTag className="input-icon"/>

                        <select
                            value={role}
                            onChange={(e)=>setRole(e.target.value)}
                        >

                            <option value="college">College</option>
                            <option value="department">Department</option>
                            <option value="faculty">Faculty</option>
                            <option value="student">Student</option>
                            <option value="client">Client</option>

                        </select>

                    </div>

                    <div className="input-group">

                        <FaUser className="input-icon"/>

                        <input

                            type="text"

                            placeholder={getIdPlaceholder()}

                            value={userId}

                            onChange={(e)=>setUserId(e.target.value)}

                        />

                    </div>

                    <div className="input-group">

                        <FaUser className="input-icon"/>

                        <input

                            type="text"

                            placeholder="Full Name"

                            value={name}

                            onChange={(e)=>setName(e.target.value)}

                        />

                    </div>

                    <div className="input-group">

                        <FaEnvelope className="input-icon"/>

                        <input

                            type="email"

                            placeholder="Email"

                            value={email}

                            onChange={(e)=>setEmail(e.target.value)}

                        />

                    </div>

                    <div className="input-group">

                        <FaPhone className="input-icon"/>

                        <input

                            type="tel"

                            placeholder="Mobile Number"

                            value={mobile}

                            onChange={(e)=>setMobile(e.target.value)}

                        />

                    </div>

                    <div className="input-group">

                        <FaLock className="input-icon"/>

                        <input

                            type="password"

                            placeholder="Password"

                            value={password}

                            onChange={(e)=>setPassword(e.target.value)}

                        />

                    </div>

                    <div className="input-group">

                        <FaLock className="input-icon"/>

                        <input

                            type="password"

                            placeholder="Confirm Password"

                            value={confirmPassword}

                            onChange={(e)=>setConfirmPassword(e.target.value)}

                        />

                    </div>

                    <div className="terms">

                        <input

                            type="checkbox"

                            checked={agree}

                            onChange={(e)=>setAgree(e.target.checked)}

                        />

                        <span>

                            I agree to the Terms & Conditions
                            and Privacy Policy.

                        </span>

                    </div>

                    <button onClick={handleRegister}>

                        Create Account

                    </button>

                    <div className="bottom-link">

                        Already have an account?

                        <Link to="/">

                            Sign In

                        </Link>

                    </div>

                </div>

            </div>

        </div>

    );

}