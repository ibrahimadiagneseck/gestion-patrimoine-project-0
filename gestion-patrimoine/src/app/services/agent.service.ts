import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { Agent } from '../model/agent.model';

@Injectable({
  providedIn: 'root'
})
export class AgentService {

  private urlServeur = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}


  public listeAgents(): Observable<Agent[]> {
    return this.httpClient.get<Agent[]>(`${this.urlServeur}/Agents`);
  }

  public ajouterAgent(formData: FormData): Observable<Agent> {
    return this.httpClient.post<Agent>(`${this.urlServeur}/AjouterAgent`, formData);
  }

  public modifierAgent(formData: FormData): Observable<Agent> {
    return this.httpClient.post<Agent>(`${this.urlServeur}/ModifierAgent`, formData);
  }

  public supprimerAgent(matriculeAgentCodeCorpsAgent: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerAgentByAgentId/${matriculeAgentCodeCorpsAgent}`);
  }


  public createBonEntreeFormData(agent: Agent): FormData {

    const formData = new FormData();

    formData.append('matriculeAgent', agent.matriculeAgent);
    formData.append('codeAgent', agent.codeAgent);
    formData.append('nomAgent', agent.nomAgent);
    formData.append('prenomAgent', agent.prenomAgent);
    formData.append('fonctionAgent', JSON.stringify(agent.fonctionAgent));
    formData.append('numeroTelephoneAgent', agent.numeroTelephoneAgent.toString());
    formData.append('uniteDouaniere', JSON.stringify(agent.uniteDouaniere));
    formData.append('codeCorpsAgent', JSON.stringify(agent.codeCorpsAgent));



    return formData;
  }
}
