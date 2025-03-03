import { createBrowserRouter } from "react-router-dom";
import Layout from "@/layouts/DashboardLayout";
import Dashboard from "@/pages/user/Dashboard";
import AgriLearn from "@/pages/user/agriLearn/AgriLearn";

const appRoutes = createBrowserRouter([
    {
        path: "/",
        element: <Layout />,
        children: [
            {
                index: true,
                element: <Dashboard />,
            },
            {
                path: "analytics",
                element: <h1 className="title">Analytics</h1>,
            },
            {
                path: "reports",
                element: <h1 className="title">Reports</h1>,
            },
            {
                path: "agri-learn",
                element: <AgriLearn />,
            },
            {
                path: "crops",
                element: <h1 className="title">Crops</h1>,
            },
            {
                path: "livestock",
                element: <h1 className="title">Livestock</h1>,
            },
            {
                path: "data-insights",
                element: <h1 className="title">Data Insights</h1>,
            },
            {
                path: "collaboration",
                element: <h1 className="title">Collaboration</h1>,
            },
            {
                path: "listings",
                element: <h1 className="title">Listings</h1>,
            },
            {
                path: "applications",
                element: <h1 className="title">Applications</h1>,
            },
            {
                path: "funding-documents",
                element: <h1 className="title">Funding Documents</h1>,
            },{
                path: "insights",
                element: <h1 className="title">Insights</h1>,
            },{
                path: "savings",
                element: <h1 className="title">Savings Goals</h1>,
            },{
                path: "financial-plans",
                element: <h1 className="title">Financial Goals</h1>,
            },{
                path: "reminders",
                element: <h1 className="title">Reminders</h1>,
            },{
                path: "schedules",
                element: <h1 className="title">Schedules</h1>,
            },{
                path: "notes",
                element: <h1 className="title">Notes</h1>,
            },{
                path: "to-do-list",
                element: <h1 className="title">To-Do List</h1>,
            },{
                path: "media",
                element: <h1 className="title">Media</h1>,
            },{
                path: "productivity-documents",
                element: <h1 className="title">Productivity Documents</h1>,
            },{
                path: "settings",
                element: <h1 className="title">Settings</h1>,
            },{
                path: "logout",
                element: <h1 className="title">Log out</h1>,
            },
        ],
    },
]);

export default appRoutes;
