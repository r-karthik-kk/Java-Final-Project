import { useState } from "react";
import { Outlet } from "react-router-dom";

import Navbar from "./Navbar";
import Sidebar from "./Sidebar";

import "./CollegeLayout.css";

export default function CollegeLayout() {

    const [sidebarOpen, setSidebarOpen] = useState(false);

    const toggleSidebar = () => {

        setSidebarOpen(!sidebarOpen);

    };

    return (

        <div className="college-layout">

            <Sidebar

                sidebarOpen={sidebarOpen}

                toggleSidebar={toggleSidebar}

            />

            <div className="layout-content">

                <Navbar

                    toggleSidebar={toggleSidebar}

                />

                <main className="page-content">

                    <Outlet />

                </main>

            </div>

        </div>

    );

}