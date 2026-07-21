import { useEffect, useState } from "react";
import {
    FaBars,
    FaKey,
    FaUserCircle,
    FaSignOutAlt
} from "react-icons/fa";

import "./Navbar.css";

export default function Navbar({ toggleSidebar }) {

    const [currentTime, setCurrentTime] = useState("");

    useEffect(() => {

        const updateClock = () => {

            const now = new Date();

            setCurrentTime(
                now.toLocaleString("en-IN", {
                    weekday: "short",
                    day: "2-digit",
                    month: "short",
                    year: "numeric",
                    hour: "2-digit",
                    minute: "2-digit",
                    second: "2-digit"
                })
            );

        };

        updateClock();

        const interval = setInterval(updateClock, 1000);

        return () => clearInterval(interval);

    }, []);

    return (

        <header className="navbar">

            <div className="navbar-left">

                <button
                    className="menu-btn"
                    onClick={toggleSidebar}
                >
                    <FaBars />
                </button>

                <div className="logo">

                    PMS

                </div>

                <div className="title">

                    Project Management System

                </div>

            </div>

            <div className="navbar-right">

                <div className="clock">

                    {currentTime}

                </div>

                <button className="nav-btn">

                    <FaKey />

                    <span>Change Password</span>

                </button>

                <button className="nav-btn">

                    <FaUserCircle />

                    <span>Profile</span>

                </button>

                <button className="nav-btn logout">

                    <FaSignOutAlt />

                    <span>Logout</span>

                </button>

            </div>

        </header>

    );

}