import "./Sidebar.css";
import {
    FaTachometerAlt,
    FaUserGraduate,
    FaChalkboardTeacher,
    FaProjectDiagram,
    FaBuilding,
    FaChartBar,
    FaCog
} from "react-icons/fa";

import { NavLink } from "react-router-dom";

export default function Sidebar({

    sidebarOpen,

    toggleSidebar

}) {
    const menus = [
        {
            name: "Dashboard",
            path: "/college/dashboard",
            icon: <FaTachometerAlt />
        },
        {
            name: "Students",
            path: "/college/students",
            icon: <FaUserGraduate />
        },
        {
            name: "Faculty",
            path: "/college/faculty",
            icon: <FaChalkboardTeacher />
        },
        {
            name: "Projects",
            path: "/college/projects",
            icon: <FaProjectDiagram />
        },
        {
            name: "Clients",
            path: "/college/clients",
            icon: <FaBuilding />
        },
        {
            name: "Reports",
            path: "/college/reports",
            icon: <FaChartBar />
        },
        {
            name: "Settings",
            path: "/college/settings",
            icon: <FaCog />
        }
    ];

    return (

<aside
    className={
        sidebarOpen
            ? "sidebar open"
            : "sidebar"
    }
>
            <div className="sidebar-logo">

                PMS

            </div>

            <nav>

                {

                    menus.map((menu) => (

                        <NavLink

                            key={menu.name}

                            to={menu.path}

                            className={({ isActive }) =>
                                isActive
                                    ? "menu active"
                                    : "menu"
                            }

                        >

                            <span className="icon">

                                {menu.icon}

                            </span>

                            <span>

                                {menu.name}

                            </span>

                        </NavLink>

                    ))

                }

            </nav>

        </aside>

    );

}