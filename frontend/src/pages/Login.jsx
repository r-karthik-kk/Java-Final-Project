import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

import { login } from "../api/authApi";
import loginImage from "../assets/Project_Logo_3.png";
import "./Login.css";

export default function Login() {

    const [role, setRole] = useState("college");
    const [userId, setUserId] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);

    const navigate = useNavigate();

    const handleLogin = async () => {

        if (!userId.trim() || !password.trim()) {
            alert("Please enter User ID and Password");
            return;
        }

        setLoading(true);

        try {

            await login({
                role,
                username: userId,
                password
            });

            switch (role) {

                case "college":
                    navigate("/college/dashboard");
                    break;

                case "department":
                    navigate("/department/dashboard");
                    break;

                case "faculty":
                    navigate("/faculty/dashboard");
                    break;

                case "student":
                    navigate("/student/dashboard");
                    break;

                case "client":
                    navigate("/client/dashboard");
                    break;

                default:
                    navigate("/");

            }

        } catch {

            alert("Invalid User ID or Password");

        } finally {

            setLoading(false);

        }

    };

    const getPlaceholder = () => {

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

    return (

        <div className="auth-page">

            <div className="auth-visual">

                <img
                    src={loginImage}
                    alt="Project Management"
                    className="auth-visual-img"
                />

                <h1>Project Management<br />System</h1>

                <p>
                    Manage Students, Faculty, Departments,
                    Projects and Clients from one secure platform.
                </p>

            </div>

            <div className="auth-form-side">

                <div className="auth-card">

                    <span className="auth-card-tag">ACCESS PORTAL</span>

                    <h2 className="auth-title">Welcome Back</h2>
                    <p className="auth-subtitle">Sign in to continue</p>

                    {/* COMBINED ROLE (30%) + ID (70%) BOX */}
                    <div className="combo-group">

                        <div className="combo-role">

                            <select
                                value={role}
                                onChange={(e) => setRole(e.target.value)}
                                disabled={loading}
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
                                placeholder={getPlaceholder()}
                                value={userId}
                                onChange={(e) => setUserId(e.target.value)}
                                disabled={loading}
                            />

                        </div>

                    </div>

                    {/* PASSWORD BOX (same background as combo box) */}
                    <div className="password-group">

                        <input
                            type="password"
                            placeholder="Password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            disabled={loading}
                        />

                    </div>

                    <button
                        className="auth-btn ripple-btn"
                        onClick={handleLogin}
                        disabled={loading}
                    >
                        {loading ? "Signing In..." : "Login"}
                    </button>

                    <div className="auth-links">

                        <Link to="/forgot-password">Forgot Password?</Link>

                        <Link to="/register">Create New Account</Link>

                    </div>

                </div>

            </div>

        </div>

    );

}