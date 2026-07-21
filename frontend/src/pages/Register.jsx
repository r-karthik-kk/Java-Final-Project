import { useState } from "react";
import { Link } from "react-router-dom";

import loginImage from "../assets/Project_Logo_3.png";
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

        <div className="auth-page">

            <div className="auth-visual">

                <div className="visual-glow"></div>

                <img
                    src={loginImage}
                    alt="Register"
                    className="auth-visual-img"
                />

                <h1>Join Project Management<br />System</h1>

                <p>
                    Register to manage projects,
                    students, faculty and departments.
                </p>

                <div className="role-chip-row">

                    <span className="role-chip">Students</span>
                    <span className="role-chip">Faculty</span>
                    <span className="role-chip">Departments</span>
                    <span className="role-chip">Clients</span>

                </div>

            </div>

            <div className="auth-form-side">

                <div className="auth-card">

                    <span className="auth-card-tag">JOIN THE PORTAL</span>

                    <h2 className="auth-title">Create Account</h2>
                    <p className="auth-subtitle">Create your account to continue</p>

                    {/* COMBINED ROLE (30%) + ID (70%) BOX */}
                    <div className="combo-group">

                        <div className="combo-role">

                            <select
                                value={role}
                                onChange={(e) => setRole(e.target.value)}
                            >
                                <option value="college">College</option>
                                <option value="department">Department</option>
                                <option value="faculty">Faculty</option>
                                <option value="student">Student</option>
                                <option value="client">Client</option>
                            </select>

                        </div>

                        <div className="combo-divider"></div>

                        <div className="combo-id">

                            <input
                                type="text"
                                placeholder={getIdPlaceholder()}
                                value={userId}
                                onChange={(e) => setUserId(e.target.value)}
                            />

                        </div>

                    </div>

                    <div className="password-group">

                        <input
                            type="text"
                            placeholder="Full Name"
                            value={name}
                            onChange={(e) => setName(e.target.value)}
                        />

                    </div>

                    <div className="password-group">

                        <input
                            type="email"
                            placeholder="Email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />

                    </div>

                    <div className="password-group">

                        <input
                            type="tel"
                            placeholder="Mobile Number"
                            value={mobile}
                            onChange={(e) => setMobile(e.target.value)}
                        />

                    </div>

                    <div className="password-group">

                        <input
                            type="password"
                            placeholder="Password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />

                    </div>

                    <div className="password-group">

                        <input
                            type="password"
                            placeholder="Confirm Password"
                            value={confirmPassword}
                            onChange={(e) => setConfirmPassword(e.target.value)}
                        />

                    </div>

                    <div className="terms">

                        <input
                            type="checkbox"
                            checked={agree}
                            onChange={(e) => setAgree(e.target.checked)}
                        />

                        <span>
                            I agree to the Terms & Conditions
                            and Privacy Policy.
                        </span>

                    </div>

                    <button
                        className="auth-btn ripple-btn"
                        onClick={handleRegister}
                    >
                        Create Account <span className="btn-arrow">→</span>
                    </button>

                    <div className="auth-links">

                        <Link to="/">Already have an account? Sign In</Link>

                    </div>

                </div>

            </div>

        </div>

    );

}