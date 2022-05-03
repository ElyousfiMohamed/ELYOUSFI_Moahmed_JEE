export interface Etudiant {
    id: number
    nom: string;
    prenom: string;
    email: string;
    dateNaissance: Date;
    genre: Genre;
    enRegle: boolean;
}

enum Genre {
    F,
    H
}