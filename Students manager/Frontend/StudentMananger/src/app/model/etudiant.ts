export interface Etudiant {
  id: number
  nom: string;
  prenom: string;
  email: string;
  imageUrl: string;
  dateNaissance: Date;
  genre: Genre;
  enRegle: boolean;
}

export enum Genre {
  M,
  F
}


