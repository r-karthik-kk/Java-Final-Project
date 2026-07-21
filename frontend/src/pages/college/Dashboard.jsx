import "./Dashboard.css";

export default function Dashboard() {

    return (

        <div className="dashboard">

            <div className="dashboard-header">

                <div>

                    <h1>Welcome, College Administrator</h1>

                    <p>
                        Manage students, faculty, projects, clients and monitor
                        the overall project management system.
                    </p>

                </div>

            </div>

            <div className="dashboard-cards">

                <div className="dashboard-card">

                    <h2>Students</h2>

                    <h3>560</h3>

                    <p>Total Registered Students</p>

                </div>

                <div className="dashboard-card">

                    <h2>Faculty</h2>

                    <h3>42</h3>

                    <p>Total Faculty Members</p>

                </div>

                <div className="dashboard-card">

                    <h2>Projects</h2>

                    <h3>128</h3>

                    <p>Projects in Progress</p>

                </div>

                <div className="dashboard-card">

                    <h2>Clients</h2>

                    <h3>34</h3>

                    <p>Active Clients</p>

                </div>

            </div>

            <div className="dashboard-sections">

                <div className="dashboard-panel">

                    <h2>Recent Activities</h2>

                    <ul>

                        <li>New student registered.</li>

                        <li>Faculty assigned to Project A.</li>

                        <li>Client meeting scheduled.</li>

                        <li>Project submission uploaded.</li>

                    </ul>

                </div>

                <div className="dashboard-panel">

                    <h2>Upcoming Reviews</h2>

                    <ul>

                        <li>AI Project Review - Tomorrow</li>

                        <li>Web Project Demo - Friday</li>

                        <li>Client Presentation - Monday</li>

                    </ul>

                </div>

            </div>

        </div>

    );

}