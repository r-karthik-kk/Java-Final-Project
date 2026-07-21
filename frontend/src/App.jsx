import { Routes, Route, Navigate } from "react-router-dom";

import Login from "./pages/Login";
import Register from "./pages/Register";
import ForgotPassword from "./pages/ForgotPassword";

import CollegeLayout from "./components/college/layouts/CollegeLayout";

import Dashboard from "./pages/college/Dashboard";

// Future College Pages
// import Students from "./pages/college/Students";
// import Faculty from "./pages/college/Faculty";
// import Projects from "./pages/college/Projects";
// import Clients from "./pages/college/Clients";
// import Reports from "./pages/college/Reports";
// import Settings from "./pages/college/Settings";

export default function App() {

    return (

        <Routes>

            {/* Authentication */}

            <Route
                path="/"
                element={<Login />}
            />

            <Route
                path="/register"
                element={<Register />}
            />

            <Route
                path="/forgot-password"
                element={<ForgotPassword />}
            />

            {/* College Module */}

            <Route
                path="/college"
                element={<CollegeLayout />}
            >

                <Route
                    index
                    element={<Navigate to="dashboard" replace />}
                />

                <Route
                    path="dashboard"
                    element={<Dashboard />}
                />

                {/*
                <Route
                    path="students"
                    element={<Students />}
                />

                <Route
                    path="faculty"
                    element={<Faculty />}
                />

                <Route
                    path="projects"
                    element={<Projects />}
                />

                <Route
                    path="clients"
                    element={<Clients />}
                />

                <Route
                    path="reports"
                    element={<Reports />}
                />

                <Route
                    path="settings"
                    element={<Settings />}
                />
                */}

            </Route>

            {/* Future Modules */}

            {/*
            <Route path="/department/*" element={<DepartmentLayout />} />
            <Route path="/faculty/*" element={<FacultyLayout />} />
            <Route path="/student/*" element={<StudentLayout />} />
            <Route path="/client/*" element={<ClientLayout />} />
            */}

            {/* 404 */}

            <Route
                path="*"
                element={<Navigate to="/" replace />}
            />

        </Routes>

    );

}