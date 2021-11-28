import {ReactNode} from "react";

export default function Table({children}: {children: ReactNode}) {
    return (
        <table style={{

        }}>
            {children}
        </table>
    );
}