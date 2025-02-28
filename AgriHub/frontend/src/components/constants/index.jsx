import { ChartColumn, Home, Settings, Sprout, Bone, Database, Users, List, FileStack, Files, Zap, PiggyBank, HandCoins, BellRing, CalendarCheck2, PencilLine, ListTodo, Images, Container, LogOut} from "lucide-react";

import ProfileImage from "@/assets/profile-image.jpg";
import ProductImage from "@/assets/product-image.jpg";

export const navbarLinks = [
    {
        title: "Dashboard",
        links: [
            {
                label: "Dashboard",
                icon: Home,
                path: "/",
            },
            // {
            //     label: "Analytics",
            //     icon: ChartColumn,
            //     path: "/analytics",
            // },
            // {
            //     label: "Reports",
            //     icon: NotepadText,
            //     path: "/reports",
            // },
        ],
    },
    {
        title: "Agri-Learn",
        links: [
            {
                label: "Agri-Learn",
                icon: ChartColumn,
                path: "/agri-learn",
            },
            // {
            //     label: "New customer",
            //     icon: UserPlus,
            //     path: "/new-customer",
            // },
            // {
            //     label: "Verified customers",
            //     icon: UserCheck,
            //     path: "/verified-customers",
            // },
        ],
    },
    {
        title: "My Farm",
        links: [
            {
                label: "Crops",
                icon: Sprout,
                path: "/crops",
            },
            {
                label: "Livestock",
                icon: Bone,
                path: "/livestock",
            },
            {
                label: "Data Insights",
                icon: Database,
                path: "/data-insights",
            },
            {
                label: "Collaboration",
                icon: Users,
                path: "/collaboration",
            },
        ],
    },
    {
        title: "Marketplace",
        links: [
            {
                label: "Listings",
                icon: List,
                path: "/listings",
            },
        ],
    },
    {
        title: "Funding",
        links: [
            {
                label: "Applications",
                icon: FileStack,
                path: "/applications",
            },
            {
                label: "Documents",
                icon: Files,
                path: "/funding-documents",
            },
            {
                label: "Insights",
                icon: Zap,
                path: "/insights",
            },
        ],
    },
    {
        title: "Finance",
        links: [
            {
                label: "Savings Goals",
                icon: PiggyBank,
                path: "/savings",
            },
            {
                label: "Financial Plans",
                icon: HandCoins,
                path: "/financial-plans",
            },
        ],
    },
    {
        title: "Productivity",
        links: [
            {
                label: "Reminders",
                icon: BellRing,
                path: "/reminders",
            },
            {
                label: "Schedules",
                icon: CalendarCheck2,
                path: "/schedules",
            },{
                label: "Notes",
                icon: PencilLine,
                path: "/notes",
            },{
                label: "To-Do List",
                icon: ListTodo,
                path: "/to-do-list",
            },{
                label: "Media",
                icon: Images,
                path: "/media",
            },{
                label: "Documents",
                icon: Container,
                path: "/productivity-documents",
            },
        ],
    },
    {
        title: "Settings",
        links: [
            {
                label: "Settings",
                icon: Settings,
                path: "/settings",
            },
            {
                label: "Log out",
                icon: LogOut,
                path: "/logout",
            },
        ],
    },
];

export const overviewData = [
    {
        name: "Jan",
        total: 1500,
    },
    {
        name: "Feb",
        total: 2000,
    },
    {
        name: "Mar",
        total: 1000,
    },
    {
        name: "Apr",
        total: 5000,
    },
    {
        name: "May",
        total: 2000,
    },
    {
        name: "Jun",
        total: 5900,
    },
    {
        name: "Jul",
        total: 2000,
    },
    {
        name: "Aug",
        total: 5500,
    },
    {
        name: "Sep",
        total: 2000,
    },
    {
        name: "Oct",
        total: 4000,
    },
    {
        name: "Nov",
        total: 1500,
    },
    {
        name: "Dec",
        total: 2500,
    },
];

export const recentSalesData = [
    {
        id: 1,
        name: "Olivia Martin",
        email: "olivia.martin@email.com",
        image: ProfileImage,
        total: 1500,
    },
    {
        id: 2,
        name: "James Smith",
        email: "james.smith@email.com",
        image: ProfileImage,
        total: 2000,
    },
    {
        id: 3,
        name: "Sophia Brown",
        email: "sophia.brown@email.com",
        image: ProfileImage,
        total: 4000,
    },
    {
        id: 4,
        name: "Noah Wilson",
        email: "noah.wilson@email.com",
        image: ProfileImage,
        total: 3000,
    },
    {
        id: 5,
        name: "Emma Jones",
        email: "emma.jones@email.com",
        image: ProfileImage,
        total: 2500,
    },
    {
        id: 6,
        name: "William Taylor",
        email: "william.taylor@email.com",
        image: ProfileImage,
        total: 4500,
    },
    {
        id: 7,
        name: "Isabella Johnson",
        email: "isabella.johnson@email.com",
        image: ProfileImage,
        total: 5300,
    },
];

export const topProducts = [
    {
        number: 1,
        name: "Wireless Headphones",
        image: ProductImage,
        description: "High-quality noise-canceling wireless headphones.",
        price: 99.99,
        status: "In Stock",
        rating: 4.5,
    },
    {
        number: 2,
        name: "Smartphone",
        image: ProductImage,
        description: "Latest 5G smartphone with excellent camera features.",
        price: 799.99,
        status: "In Stock",
        rating: 4.7,
    },
    {
        number: 3,
        name: "Gaming Laptop",
        image: ProductImage,
        description: "Powerful gaming laptop with high-end graphics.",
        price: 1299.99,
        status: "In Stock",
        rating: 4.8,
    },
    {
        number: 4,
        name: "Smartwatch",
        image: ProductImage,
        description: "Stylish smartwatch with fitness tracking features.",
        price: 199.99,
        status: "Out of Stock",
        rating: 4.4,
    },
    {
        number: 5,
        name: "Bluetooth Speaker",
        image: ProductImage,
        description: "Portable Bluetooth speaker with deep bass sound.",
        price: 59.99,
        status: "In Stock",
        rating: 4.3,
    },
    {
        number: 6,
        name: "4K Monitor",
        image: ProductImage,
        description: "Ultra HD 4K monitor with stunning color accuracy.",
        price: 399.99,
        status: "In Stock",
        rating: 4.6,
    },
    {
        number: 7,
        name: "Mechanical Keyboard",
        image: ProductImage,
        description: "Mechanical keyboard with customizable RGB lighting.",
        price: 89.99,
        status: "In Stock",
        rating: 4.7,
    },
    {
        number: 8,
        name: "Wireless Mouse",
        image: ProductImage,
        description: "Ergonomic wireless mouse with precision tracking.",
        price: 49.99,
        status: "In Stock",
        rating: 4.5,
    },
    {
        number: 9,
        name: "Action Camera",
        image: ProductImage,
        description: "Waterproof action camera with 4K video recording.",
        price: 249.99,
        status: "In Stock",
        rating: 4.8,
    },
    {
        number: 10,
        name: "External Hard Drive",
        image: ProductImage,
        description: "Portable 2TB external hard drive for data storage.",
        price: 79.99,
        status: "Out of Stock",
        rating: 4.5,
    },
];
