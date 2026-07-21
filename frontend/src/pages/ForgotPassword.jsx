import { useState } from "react";
import { Link } from "react-router-dom";
import { FaEnvelope, FaArrowLeft } from "react-icons/fa";
import "./ForgotPassword.css";

export default function ForgotPassword() {

    const [email, setEmail] = useState("");

    const handleReset = () => {

        if (!email.trim()) {
            alert("Please enter your email.");
            return;
        }

        alert("Password reset functionality will be implemented.");

    };

    return (

        <div className="forgot-page">

            <div className="forgot-left">

                <img
                    src="/forgot-password.png"
                    alt="Forgot Password"
                />

                <h1>Forgot Password?</h1>

                <p>

                    Don't worry! Enter your registered email address.
                    We'll send you instructions to reset your password.

                </p>

            </div>

            <div className="forgot-right">

                <div className="forgot-card">

                    <h2>Reset Password</h2>

                    <p>

                        Enter your registered email address.

                    </p>

                    <div className="input-group">

                        <FaEnvelope className="input-icon" />

                        <input

                            type="email"

                            placeholder="Enter Email Address"

                            value={email}

                            onChange={(e) => setEmail(e.target.value)}

                        />

                    </div>

                    <button onClick={handleReset}>

                        Send Reset Link

                    </button>

                    <Link
                        to="/"
                        className="back-link"
                    >

                        <FaArrowLeft />

                        Back to Login

                    </Link>

                </div>

            </div>

        </div>

    );

}