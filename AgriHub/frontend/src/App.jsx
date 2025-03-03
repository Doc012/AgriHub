import { RouterProvider } from "react-router-dom";
import { ThemeProvider } from "@/contexts/ThemeContext";
import appRoutes from "@/routes/appRoutes";

function App() {
    return (
        <ThemeProvider storageKey="theme">
            <RouterProvider router={appRoutes} />
        </ThemeProvider>
    );
}

export default App;
